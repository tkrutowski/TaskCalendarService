package net.focik.taskcalendar.infrastructure.query;

import net.focik.taskcalendar.infrastructure.dto.EntryQueryDbDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

interface ITaskCalendarQueryDtoRepository extends JpaRepository<EntryQueryDbDto, Integer> {


    List<EntryQueryDbDto> findAllByDateOrderByDate(LocalDate date);
    List<EntryQueryDbDto> findAllByDateBetweenOrderByDate(LocalDate startDate, LocalDate endDate);

}
