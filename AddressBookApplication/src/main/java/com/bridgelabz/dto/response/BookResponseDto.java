package com.bridgelabz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    private String bookName;
    private String bookAuthor;
    private String bookGenere;
    private  int bookPrice;
}
