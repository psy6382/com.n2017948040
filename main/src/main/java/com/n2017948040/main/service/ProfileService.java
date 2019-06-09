package com.n2017948040.main.service;

import com.n2017948040.main.domain.Profile;
import com.n2017948040.main.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile findProfileByIdx(Long idx){
        return profileRepository.findById(idx).orElse(new Profile());
    }

    public List<Profile> findProfileListCollections() {
        return profileRepository.findAll();
    }

    public Profile saveProfile(Profile profile){
        return profileRepository.save(profile);
    }

    public void deleteByProfileId(Long idx){
        profileRepository.deleteById(idx);
    }

    public void updateProfile(Profile profile, Long idx) {
        Profile persistProfile = profileRepository.getOne(idx);
        persistProfile.updateProfile(profile);
        profileRepository.save(persistProfile);
    }
}
