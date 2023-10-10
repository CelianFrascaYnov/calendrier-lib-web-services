package com.example.libcalendar.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class MoisCalendrier {
    private List<List<Integer>> semaineMois;
}