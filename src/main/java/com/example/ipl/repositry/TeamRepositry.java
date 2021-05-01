package com.example.ipl.repositry;

import com.example.ipl.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepositry extends CrudRepository<Team,Long> {
    Team findByTeamName(String teamName);

}
