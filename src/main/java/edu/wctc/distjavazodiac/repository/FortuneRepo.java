package edu.wctc.distjavazodiac.repository;

import edu.wctc.distjavazodiac.entity.Fortune;
import org.springframework.data.repository.CrudRepository;

public interface FortuneRepo extends CrudRepository<Fortune,Integer> {
}
