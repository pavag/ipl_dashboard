package data;

import com.example.ipl.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

        private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

        @Override
        public Match process(final MatchInput matchInput) throws Exception {

            Match match = new Match();

            match.setId(Long.parseLong(matchInput.getId()));
            match.setCity(matchInput.getCity());
            match.setDate(LocalDate.parse(matchInput.getDate()));
            match.setPlayerOfMatch(match.getPlayerOfMatch());
            match.setVenue(match.getVenue());

            String firstInnTeam, secondInnTeam;

            if("bat".equalsIgnoreCase(matchInput.getToss_decision())) {
                firstInnTeam = matchInput.getToss_winner();
                secondInnTeam = firstInnTeam.equalsIgnoreCase(matchInput.getTeam1()) ? matchInput.getTeam2() : matchInput.getTeam1();
            }
            else {
                secondInnTeam = matchInput.getToss_winner();
                firstInnTeam = secondInnTeam.equalsIgnoreCase(matchInput.getTeam1()) ? matchInput.getTeam2() : matchInput.getTeam1();
            }

            match.setTeam1(firstInnTeam);
            match.setTeam2(secondInnTeam);
            match.setTossWinner(matchInput.getToss_winner());
            match.setTossDecision(matchInput.getToss_decision());
            match.setMatchWinner(matchInput.getWinner());
            match.setResult(matchInput.getResult());
            match.setResultMargin(matchInput.getResult_margin());
            match.setUmpire1(matchInput.getUmpire1());
            match.setUmpire2(matchInput.getUmpire2());

            return match;
        }
}
