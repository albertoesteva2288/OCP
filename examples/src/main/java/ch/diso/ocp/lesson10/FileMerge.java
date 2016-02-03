package ch.diso.ocp.lesson10;

import com.plutext.merge.BlockRange;
import com.plutext.merge.DocumentBuilderIncremental;
import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.docx4j.Docx4J;
import org.docx4j.convert.out.pdf.PdfConversion;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileMerge extends DirectoryWalker {

    private static final Logger LOGGER = Logger.getLogger(FileMerge.class.getName());

    /*
     * Datenstrom für unsere Zieldatei.
     */
    private OutputStream output = null;

    /*
     * Zieldatei für unsere Datei.
     */
    private File destinationFile;

    /*
     * Interne Datenstruktur zur Verarbeitung der Worddateien.
     */
    private DocumentBuilderIncremental documentBuilder =
            new DocumentBuilderIncremental();

    /*
     * Liste aller verarbeiteten Dateien.
     */
    private Collection<File> processedFiles = new ArrayList<>();

    /**
     * Zusammenführen mehrerer Dateien.
     *
     * @param sourceDirectory In diesem Verzeichnis werden die Dateien gesucht
     * @param destinationFile Zieldatei unserer Verarbeitung
     * @throws IOException
     */
    public FileMerge(File sourceDirectory, File destinationFile)
            throws IOException {
        this(sourceDirectory, destinationFile, ".docx");
    }

    /*
     * Aktuell erlauben wir nicht unterschiedliche Dateitypen zu verwenden. Aus
     * diesem Grund ist dieser Konstruktor als 'private' deklariert.
     */
    private FileMerge(File sourceDirectory, File destinationFile, String fileSuffix)
            throws IOException {
        super(FileFilterUtils.suffixFileFilter(fileSuffix), -1);

        this.destinationFile = destinationFile;

        // output = createAppendableStream(destinationFile); // Für Textdateien
        walk(sourceDirectory, processedFiles);
    }


    @Override
    protected boolean handleDirectory(File directory, int depth, Collection results)
            throws IOException {
        LOGGER.info("Processing directory '" + directory.getName() + "'");
        return true;
    }

    @Override
    protected void handleFile(File sourceFile, int depth, Collection results)
            throws IOException {
        if ((processedFiles.size() % 1_000) == 0) {
            LOGGER.info("Processed " + processedFiles.size() + " files");
        }
        mergeWordFiles(sourceFile);
        processedFiles.add(sourceFile);
    }

    @Override
    protected void handleEnd(Collection results)
            throws IOException {
        try {
            WordprocessingMLPackage wordOutput = documentBuilder.finish();
            Docx4J.save(wordOutput, destinationFile, Docx4J.FLAG_NONE);
            LOGGER.info("Merged " + processedFiles.size() + " files into '" +
                    destinationFile.getName() + "'");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            throw new IOException(e);
        }

        // IOUtils.closeQuietly(output);
    }

    private void mergeTextFiles(File sourceFile) throws IOException {
        InputStream input = null;
        try {
            input = new BufferedInputStream(new FileInputStream(sourceFile));
            IOUtils.copy(input, output);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

    private void mergeWordFiles(File wordFile) throws IOException {
        try {
            BlockRange block = new BlockRange(Docx4J.load(wordFile));

            block.setSectionBreakBefore(BlockRange.SectionBreakBefore.NEXT_PAGE);
            block.setRestartPageNumbering(true);

            if (processedFiles.size() == 0 ) {
                block.setHeaderBehaviour(BlockRange.HfBehaviour.DEFAULT);
                block.setFooterBehaviour(BlockRange.HfBehaviour.DEFAULT);
            } else {
                block.setHeaderBehaviour(BlockRange.HfBehaviour.INHERIT);
                block.setFooterBehaviour(BlockRange.HfBehaviour.INHERIT);
            }

            // block.setStyleHandler(BlockRange.StyleHandler.RENAME_RETAIN);
            // block.setNumberingHandler(BlockRange.NumberingHandler.ADD_NEW_LIST);

            documentBuilder.addBlockRange(block, false);

        } catch (Docx4JException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            throw new IOException(e);
        }
    }

    private BufferedOutputStream createAppendableStream(File destination)
            throws FileNotFoundException {
        return new BufferedOutputStream(new FileOutputStream(destination, true));
    }

    /**
     * Diese Version funktioniert lediglich mit Textdateien.
     */
    private void appendFile(OutputStream output, File source)
            throws IOException {
        InputStream input = null;
        try {
            input = new BufferedInputStream(new FileInputStream(source));
            IOUtils.copy(input, output);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }

    /**
     * Diese Methode wird lediglich zu Testzwecken verwenden.
     */
    public static void main(String[] args) throws Exception {

        new FileMerge(
                new File("/Users/daniel/Downloads/documents1"),
                // new File("testDocuments"),
                new File("/tmp/out.docx"));
    }

}