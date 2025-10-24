package io.github.isaevisa05.TGBot.repository;

import io.github.isaevisa05.TGBot.entity.Income;
import io.github.isaevisa05.TGBot.entity.Spend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendRepository extends JpaRepository<Spend, Long> {
}
