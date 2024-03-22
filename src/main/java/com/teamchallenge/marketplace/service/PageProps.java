package com.teamchallenge.marketplace.service;

import org.springframework.data.domain.Sort;

public class PageProps {
    public static final int STARTING_PAGE = 0;

    public static final int PAGE_SIZE = 20;

    public static final Sort SORT_UNSORTED = Sort.unsorted();

    public static final String SORT_DIRECTION = "ASC";
}
