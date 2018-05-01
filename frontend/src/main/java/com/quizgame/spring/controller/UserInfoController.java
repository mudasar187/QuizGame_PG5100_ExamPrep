package com.quizgame.spring.controller;

import com.quizgame.spring.entity.MatchStats;
import com.quizgame.spring.service.MatchStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Collection;

@Named
@RequestScoped
public class UserInfoController {

    @Autowired
    private MatchStatsService matchStatsService;

    public String getUserName(){
        return ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    public MatchStats getStats(){
        return matchStatsService.getMatchStats(getUserName());
    }

    /**
     * Get ROLE_ADMIN
     * @return
     */
    public boolean getAdminRoleUser() {
        Collection<? extends GrantedAuthority> role = ((UserDetails)SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal())
                .getAuthorities();
        return role.stream().anyMatch(e -> ((GrantedAuthority) e).getAuthority().contains("ROLE_ADMIN"));
    }

    /**
     * Get ROLE_USER
     */

    public boolean getUserRoleUser() {
        Collection<? extends GrantedAuthority> role = ((UserDetails)SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal())
                .getAuthorities();
        return role.stream().anyMatch(e -> ((GrantedAuthority) e).getAuthority().contains("ROLE_USER"));
    }
}