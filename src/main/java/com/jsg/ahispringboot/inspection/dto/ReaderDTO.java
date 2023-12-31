package com.jsg.ahispringboot.inspection.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReaderDTO {
    @JsonProperty("PersonalInformation")
    private PersonalInformationDTO personalInformationDTO;
    @JsonProperty("SelfIntroduction")
    private List<SelfIntroductionDTO> selfIntroductionDTO;

}
