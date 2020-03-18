package com.ex.dao;

import com.ex.model.Border;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorderMapper {

    int addBorder(Border border);

    int delBorder(int border_id);

    List<Border> getAllBorder();

    List<Border> findBorderByNames(String keyword);
}