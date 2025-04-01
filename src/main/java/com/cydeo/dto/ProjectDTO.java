package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String projectName;
    private String projectCode;
    private UserDTO assignManager;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    private String projectDetail;
    private Status projectStatus;

    /**
     * isDeleted will never be null in your case because:
     * <p>
     * Primitive boolean (lowercase) cannot be null – it defaults to false if unset.
     * <p>
     * If your form has no input field for isDeleted:
     * <p>
     * The field retains its default false (your explicit initialization)
     * <p>
     * Spring won’t override it during form binding (non-null primitives stay unchanged).
     */
    private boolean isDeleted=false;

}
