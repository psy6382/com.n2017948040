package com.n2017948040.main.service;

import com.n2017948040.main.domain.Basic;
import com.n2017948040.main.repository.BasicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicService {

    private final BasicRepository basicRepository;

    public BasicService(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    public List<Basic> findBasicListCollections(){
        return basicRepository.findAll();
    }


    public Basic findBasicByIdx(Long idx){
        return basicRepository.findById(idx).orElse(new Basic());
    }

    public Basic saveBasic(Basic basic){
        return basicRepository.save(basic);
    }

    public void deleteByBasicId(Long idx){
        basicRepository.deleteById(idx);
    }

    public void updateBasic(Basic basic, Long idx) {
        Basic persistBasic = basicRepository.getOne(idx);
        persistBasic.updateBasic(basic);
        basicRepository.save(persistBasic);
    }

}