package com.ex.service;

import com.ex.model.Border;

import java.util.List;

public interface BorderService {
    int addBorder(Border border);
    int delBorder(int border_id);
    List<Border> getAllBorder();
    List<Border> findBorderByNames(String keyword);
}
