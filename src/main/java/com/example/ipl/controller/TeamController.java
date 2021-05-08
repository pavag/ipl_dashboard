package com.example.ipl.controller;

import com.example.ipl.model.Team;
import com.example.ipl.repositry.MatchRepositry;
import com.example.ipl.repositry.TeamRepositry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TeamController {

    private TeamRepositry teamRepositry;
    private MatchRepositry matchRepositry;


    public TeamController(TeamRepositry teamRepositry, MatchRepositry matchRepositry) {
        this.teamRepositry = teamRepositry;
        this.matchRepositry = matchRepositry;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName)
    {
       Team team =   teamRepositry.findByTeamName(teamName);
       team.setMatches(matchRepositry.findLatestMatchesByteam(teamName,4));

       return  team;
    }
}
