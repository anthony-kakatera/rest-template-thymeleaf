package io.bootify.rest_template_thymeleaf.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UniversitiesDTO {

    @JsonProperty("country")
    private String country;

    @JsonProperty("web_pages")
    private String[] web_pages;

    @JsonProperty("alpha_two_code")
    private String alpha_two_code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("province")
    private String province;

    @JsonProperty("domains")
    private String[] domains;

    public UniversitiesDTO(){}

    public UniversitiesDTO(String country, String[] web_pages, String alpha_two_code, String name, String province, String[] domains) {
        this.country = country;
        this.web_pages = web_pages;
        this.alpha_two_code = alpha_two_code;
        this.name = name;
        this.province = province;
        this.domains = domains;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getWeb_pages() {
        return web_pages;
    }

    public void setWeb_pages(String[] web_pages) {
        this.web_pages = web_pages;
    }

    public String getAlpha_two_code() {
        return alpha_two_code;
    }

    public void setAlpha_two_code(String alpha_two_code) {
        this.alpha_two_code = alpha_two_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String[] getDomains() {
        return domains;
    }

    public void setDomains(String[] domains) {
        this.domains = domains;
    }
}
