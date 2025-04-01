package com.cydeo.enums;

import lombok.*;

@RequiredArgsConstructor
@Getter(AccessLevel.PUBLIC)
public enum Status {
    OPEN("open"),IN_PROGRESS("in progress"),COMPLETE("complete");
    private final String statusType;
}
