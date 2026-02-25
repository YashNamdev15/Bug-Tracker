package com.softwareTool.bugTracker.dto.memberUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateDto {

    Set<Long> userIds;
}
