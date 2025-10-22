package com.back.control_event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.back.control_event.model.buyout;
import java.util.Date;
import java.util.List;
import com.back.control_event.dto.BuyoutHistoryDTO;

public interface IBuyoutRepository extends JpaRepository<buyout, Integer> {
    @Query("select new com.back.control_event.dto.BuyoutHistoryDTO(e.name, le.name, b.ticket_number, b.value_total, b.date_payment, b.state_pay) " +
           "from userTicket b " +
           "join b.ticket t " +
           "join t.event e " +
           "join t.locatedEvent le " +
           "where b.user.id_user = :userId " +
           "and (:eventName is null or lower(e.name) like lower(concat('%', :eventName, '%'))) " +
           "and ((:startDate is null) or (:endDate is null) or (b.date_payment between :startDate and :endDate)) " +
           "order by b.date_payment desc")
    List<BuyoutHistoryDTO> findHistoryByUserAndFilters(
        @Param("userId") int userId,
        @Param("eventName") String eventName,
        @Param("startDate") Date startDate,
        @Param("endDate") Date endDate
    );
}
