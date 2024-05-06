package com.baseball;

import com.ui.Output;

import java.util.Objects;

public class ResumeOrNot {
    private static final int Valid_Operation_Input_Size = 1;
    private static final int Resume_Reply = 1;
    private static final int Stop_Reply = 2;
    private static final char Zero_char = '0';

    private final int opinion;

    public ResumeOrNot(String userReply) {
        isValidLength(userReply);

        this.opinion = userReply.charAt(0) - Zero_char;
        isValidOpinionRange(opinion);
    }

    private void isNullValue(String userReply) {
        if (Objects.isNull(userReply)) {
            throw new IllegalArgumentException(Output.NULL_EXCEPTION_MESSAGE);
        }
    }

    private void isValidLength(String userReply) {
        if (userReply.length() != Valid_Operation_Input_Size) {
            throw new IllegalArgumentException(Output.RESUME_INPUT_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void isValidOpinionRange(int opinion) {
        if ((opinion != Resume_Reply) && (opinion != Stop_Reply)) {
            throw new IllegalArgumentException(Output.RESUME_INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    public boolean isResume() {
        return (opinion == Resume_Reply);
    }
}
