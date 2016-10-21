package by.pvt.module4.model;

import by.pvt.module4.common.CommonEntityListImpl;

import java.util.List;

public class MemberTypes extends CommonEntityListImpl<MemberType> {

    public MemberTypes() {
        super();
    }

    public MemberTypes(List<MemberType> memberTypes) {
        super(memberTypes);
    }

    public List<MemberType> getMemberTypes() {
        return getEntity();
    }

    public void setMemberTypes(List<MemberType> memberTypes) {
        setEntity(memberTypes);
    }
}
