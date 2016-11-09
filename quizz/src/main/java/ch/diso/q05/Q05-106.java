package ch.diso.q05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ReplaceRegex {

    public static void main(String[] args) {
        String strHtml = "<p>Java is <i>not</i> coffee; it is a <b>language</b>!</p>";
        Pattern tag = Pattern.compile("(</?)[ib](>)");
        Matcher mTag = tag.matcher(strHtml);
                while (mTag.find()) {
            mTag.replaceFirst("\\1div\\2");
            mTag.replaceAll("em");
            mTag.replaceAll("strong");
        }
        System.out.println(strHtml);
    }
}