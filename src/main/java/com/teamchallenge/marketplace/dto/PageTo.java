package com.teamchallenge.marketplace.dto;

import java.util.List;

public record PageTo<T>(int totalEntries, List<T> content) {
}
