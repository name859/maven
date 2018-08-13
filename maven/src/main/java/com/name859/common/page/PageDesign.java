package com.name859.common.page;

public class PageDesign {

	private String borderPrefix = "<div>";
	private String borderSuffix = "</div>";
	
	private String activePrefix = "&nbsp;<b>";
	private String activeSuffix = "</b>&nbsp;";
	private String enabledPrefix = "&nbsp;";
	private String enabledSuffix = "&nbsp;";
	private String disabledPrefix = "&nbsp;";
	private String disabledSuffix = "&nbsp;";
	
	private String firstSymbol = "&laquo;";
	private String firstText = " FIRST";
	private String preSymbol = "&lsaquo;";
	private String preText = " PREVIOUS";
	private String nextSymbol = "&rsaquo;";
	private String nextText = "NEXT ";
	private String lastSymbol = "&raquo;";
	private String lastText = "LAST ";
	
	public PageDesign() {
		forBootstrap();
	}
	
	public void forBootstrap() {
		borderPrefix = "<div class=\"pagination\">";
		borderSuffix = "</div>";
		
		activePrefix = "<li class=\"active\">";
		activeSuffix = "</li>";
		enabledPrefix = "<li>";
		enabledSuffix = "</li>";
		disabledPrefix = "<li class=\"disabled\">";
		disabledSuffix = "</li>";
		
		firstText = "";
		preText = "";
		nextText = "";
		lastText = "";
	}
	
	public String getBorderPrefix() {
		return borderPrefix;
	}
	
	public void setBorderPrefix(String borderPrefix) {
		this.borderPrefix = borderPrefix;
	}
	
	public String getBorderSuffix() {
		return borderSuffix;
	}
	
	public void setBorderSuffix(String borderSuffix) {
		this.borderSuffix = borderSuffix;
	}
	
	public String getActivePrefix() {
		return activePrefix;
	}
	
	public void setActivePrefix(String activePrefix) {
		this.activePrefix = activePrefix;
	}
	
	public String getActiveSuffix() {
		return activeSuffix;
	}
	
	public void setActiveSuffix(String activeSuffix) {
		this.activeSuffix = activeSuffix;
	}
	
	public String getEnabledPrefix() {
		return enabledPrefix;
	}
	
	public void setEnabledPrefix(String enabledPrefix) {
		this.enabledPrefix = enabledPrefix;
	}
	
	public String getEnabledSuffix() {
		return enabledSuffix;
	}
	
	public void setEnabledSuffix(String enabledSuffix) {
		this.enabledSuffix = enabledSuffix;
	}
	
	public String getDisabledPrefix() {
		return disabledPrefix;
	}
	
	public void setDisabledPrefix(String disabledPrefix) {
		this.disabledPrefix = disabledPrefix;
	}
	
	public String getDisabledSuffix() {
		return disabledSuffix;
	}
	
	public void setDisabledSuffix(String disabledSuffix) {
		this.disabledSuffix = disabledSuffix;
	}
	
	public String getFirstSymbol() {
		return firstSymbol;
	}
	
	public void setFirstSymbol(String firstSymbol) {
		this.firstSymbol = firstSymbol;
	}
	
	public String getFirstText() {
		return firstText;
	}
	
	public void setFirstText(String firstText) {
		this.firstText = firstText;
	}
	
	public String getPreSymbol() {
		return preSymbol;
	}
	
	public void setPreSymbol(String preSymbol) {
		this.preSymbol = preSymbol;
	}
	
	public String getPreText() {
		return preText;
	}
	
	public void setPreText(String preText) {
		this.preText = preText;
	}
	
	public String getNextSymbol() {
		return nextSymbol;
	}
	
	public void setNextSymbol(String nextSymbol) {
		this.nextSymbol = nextSymbol;
	}
	
	public String getNextText() {
		return nextText;
	}
	
	public void setNextText(String nextText) {
		this.nextText = nextText;
	}
	
	public String getLastSymbol() {
		return lastSymbol;
	}
	
	public void setLastSymbol(String lastSymbol) {
		this.lastSymbol = lastSymbol;
	}
	
	public String getLastText() {
		return lastText;
	}
	
	public void setLastText(String lastText) {
		this.lastText = lastText;
	}
	
}
