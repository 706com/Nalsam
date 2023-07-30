package com.example.nalsam.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationInfoRepository extends JpaRepository<LocationInfoDTO, Double> {

    List<LocationInfoDTO> findByPointXAndPointY(int pointX,int pointY);
}

//상속을 받음으로서 jpa 의 crud 를 쓸 수 있는 것.

//개사기 문법으로 findBy column And / OR ~~다 가능