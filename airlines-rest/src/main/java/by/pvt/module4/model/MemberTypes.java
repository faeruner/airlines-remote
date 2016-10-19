package by.pvt.module4.model;

import java.io.Serializable;
import java.util.List;

public class MemberTypes implements Serializable {
    List<MemberType> memberTypes;

    public MemberTypes() {
    }

    public MemberTypes(List<MemberType> memberTypes) {
        this.memberTypes = memberTypes;
    }

    public List<MemberType> getMemberTypes() {
        return memberTypes;
    }

    public void setMemberTypes(List<MemberType> memberTypes) {
        this.memberTypes = memberTypes;
    }
}
