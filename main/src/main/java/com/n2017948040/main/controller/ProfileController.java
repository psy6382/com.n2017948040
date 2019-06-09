package com.n2017948040.main.controller;

import com.n2017948040.main.domain.Profile;
import com.n2017948040.main.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @GetMapping("/{idx}")
    public String read(@PathVariable Long idx, Model model){
        model.addAttribute("profile", profileService.findProfileByIdx(idx));
        return "profileitem";
    }

    @PostMapping("/add")
    public  String add(Profile profile, Model model){
        profile.setCreatedAtNow();
        Profile saveProfile = profileService.saveProfile(profile);
        model.addAttribute("profile", saveProfile);
        return "profileitem";
    }

    @GetMapping("/new")
    public String form(Profile profile){
        return "profilenew";
    }

    @PutMapping("/{idx}")
    public ResponseEntity<?> putBasic(@PathVariable("idx")Long idx, @RequestBody Profile profile){
        profileService.updateProfile(profile, idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteProfile(@PathVariable("idx") Long idx){
        profileService.deleteByProfileId(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }


}
