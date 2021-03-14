package net.focik.taskcalendar.infrastructure.jpa;

import net.focik.taskcalendar.infrastructure.dto.EntryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

interface ITaskCalendarDtoRepository extends JpaRepository<EntryDto, Integer> {

//    @Query(
//            value = "select id_wpisu, id_zadania, id_brygady, rodzaj_zadania, data, info\n" +
//                    "from Kalendarz_zadania",
//            nativeQuery = true)
    List<EntryDto> findAllByDateOrderByDate(LocalDate date);
    List<EntryDto> findAllByDateBetweenOrderByDate(LocalDate startDate, LocalDate endDate);
}
