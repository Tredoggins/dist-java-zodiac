package edu.wctc.distjavazodiac.service;

import edu.wctc.distjavazodiac.entity.Month;
import edu.wctc.distjavazodiac.repository.MonthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseMonthService implements MonthListService{
    @Autowired
    private MonthRepo mRepo;
    @Override
    public List<Month> getMonths() {
        List<Month> list=new ArrayList<>();
        mRepo.findAll().forEach(list::add);
        return list;
    }
}
