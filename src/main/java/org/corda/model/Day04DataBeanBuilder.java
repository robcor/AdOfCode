package org.corda.model;

public class Day04DataBeanBuilder {
    private String byr;
    private String iyr;
    private String eyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private String pid;
    private String cid;

    public Day04DataBeanBuilder setByr(String byr) {
        this.byr = byr;
        return this;
    }

    public Day04DataBeanBuilder setIyr(String iyr) {
        this.iyr = iyr;
        return this;
    }

    public Day04DataBeanBuilder setEyr(String eyr) {
        this.eyr = eyr;
        return this;
    }

    public Day04DataBeanBuilder setHgt(String hgt) {
        this.hgt = hgt;
        return this;
    }

    public Day04DataBeanBuilder setHcl(String hcl) {
        this.hcl = hcl;
        return this;
    }

    public Day04DataBeanBuilder setEcl(String ecl) {
        this.ecl = ecl;
        return this;
    }

    public Day04DataBeanBuilder setPid(String pid) {
        this.pid = pid;
        return this;
    }

    public Day04DataBeanBuilder setCid(String cid) {
        this.cid = cid;
        return this;
    }

    public Day04DataBean createDay04Data() {
        return new Day04DataBean( byr, iyr, eyr, hgt, hcl, ecl, pid, cid );
    }
}