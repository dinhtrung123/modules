<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.util.List"%>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ taglib prefix="chart" uri="http://liferay.com/tld/chart" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.percentage.donut.DonutChartConfig" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.SingleValueColumn" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.gauge.GaugeChartConfig" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.point.line.LineChartConfig" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.MultiValueColumn" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.gauge.GaugeChartConfig" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.point.line.LineChartConfig" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.MultiValueColumn" %>
<%@ page import="com.liferay.frontend.taglib.chart.model.point.bar.BarChartConfig" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />