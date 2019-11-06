package pl.bets365mj.odd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bets365mj.fixtureMisc.Season;
import pl.bets365mj.fixtureMisc.SeasonService;
import pl.bets365mj.fixtureMisc.Team;
import pl.bets365mj.fixture.Fixture;
import pl.bets365mj.fixture.FixtureRepository;

import java.util.Map;

@Controller
public class MatchStatisticController {

    @Autowired
    Statistics statistics;

    @Autowired
    FixtureRepository fixtureRepository;

    @Autowired
    SeasonService seasonService;

    @RequestMapping("/fixture-stats/{id}")
    public String odds(Model model, @PathVariable int id) {
        Fixture fixture = fixtureRepository.findById(id);
        Season season = fixture.getSeason();
        Team home = fixture.getHomeTeam();
        Team away = fixture.getAwayTeam();

        double homeTeamGoals = statistics.homeTeamGoalsPrediction(home, away, season);
        double[] homeTeamGoalsProbability = statistics.goalsNumberProbability(homeTeamGoals);
        double awayTeamGoals = statistics.awayTeamGoalsPrediction(home, away, season);
        double[] awayTeamGoalsProbability = statistics.goalsNumberProbability(awayTeamGoals);
        double[][] matchResultProbabilityMatix = statistics.matchResultProbability(homeTeamGoalsProbability, awayTeamGoalsProbability);
        Map<String, Double> odds = statistics.odds(matchResultProbabilityMatix);

        model.addAttribute("ht", home);
        model.addAttribute("at", away);
        model.addAttribute("hg", homeTeamGoals); //single goal
        model.addAttribute("ag", awayTeamGoals); //single goal
        model.addAttribute("homeGoals", homeTeamGoalsProbability);
        model.addAttribute("awayGoals", awayTeamGoalsProbability);
        model.addAttribute("result", matchResultProbabilityMatix); //match result matrix
        model.addAttribute("odds", odds);
        return "fixture-stats";
    }
}