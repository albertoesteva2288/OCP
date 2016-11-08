package ch.diso.ex22_Streams;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Class representing voting rules in an election
 */
public class VotingRules {

    /**
     * Complete this for Exercise_2_Test#getAllPersonsEligibleToVote
     *
     * @param potentialVoters  - voters to filter
     * @param legalAgeOfVoting - age where it's legal to vote
     * @return a list of eligible voters
     */
    public static List<Person> eligibleVoters(List<Person> potentialVoters, int legalAgeOfVoting) {
        return potentialVoters.stream()
                .filter(p -> p.getAge() >= legalAgeOfVoting)
                .collect(toList());
    }
}