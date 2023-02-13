<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/CHAMPIONNAT">
<html>
<head>
<title>
Ligue <xsl:value-of select="@DIVISION" />, saison <xsl:value-of select="@SAISON" />
</title>
<link rel="stylesheet" type="text/css" href="ch.css" />
<meta name="robots" content="noindex" />
</head>
<body>
<div class="pagelarge">
<h1>
Resultats de ligue <xsl:value-of select="@DIVISION" />, saison <xsl:value-of select="@SAISON" />
</h1>
<h2>Statistiques sur les conclusions des rencontres</h2>
<fieldset class="sommaire">
<legend>Sommaire</legend>
<ul>
<xsl:apply-templates select="/CHAMPIONNAT/JOURNEE" mode="sommaire" />
</ul>
</fieldset>
<xsl:variable name="nb_matches" select="count(//RENCONTRE)" />
<xsl:variable name="nb_victoires" select="count(//RENCONTRE[@SCORED > @SCOREE])" />
<xsl:variable name="pc_victoires" select="format-number(100.*$nb_victoires div $nb_matches,'##.##')" />
<xsl:variable name="nb_defaites" select="count(//RENCONTRE[@SCORED&lt;@SCOREE])" />
<xsl:variable name="pc_defaites" select="format-number(100.*$nb_defaites div $nb_matches,'##.##')" />
<xsl:variable name="nb_nuls" select="count(//RENCONTRE[@SCORED = @SCOREE])" />
<xsl:variable name="pc_nuls" select="format-number(100.*$nb_nuls div $nb_matches,'##.##')" />
<table>
<tr>
<th>Victoires de l'equipe a domicile</th>
<td align="right">
<xsl:value-of select="$nb_victoires" />/<xsl:value-of select="$nb_matches" />
</td>
<td align="right">
<xsl:value-of select="$pc_victoires" />%
</td>
</tr>
<tr>
<th>Victoires de l equipe a l exterieurr</th>
<td align="right">
<xsl:value-of select="$nb_defaites" />/<xsl:value-of select="$nb_matches" />
</td>
<td align="right">
<xsl:value-of select="$pc_defaites" />%
</td></tr>
<tr>
<th>Matches nul</th>
<td align="right">
<xsl:value-of select="$nb_nuls" />/<xsl:value-of select="$nb_matches" />
</td>
<td align="right">
<xsl:value-of select="$pc_nuls" />%
</td>
</tr>
</table>
<br />
<br />
<embed src="stats.svg" width="400" height="400" type="image/svg+xml" />
<hr />
<xsl:apply-templates select="/CHAMPIONNAT/JOURNEE" />
</div>
</body>
</html>
</xsl:template>
<xsl:template match="/CHAMPIONNAT/JOURNEE" mode="sommaire">
<li>
<a href="#{@NUMERO}">
journee N <xsl:value-of select="@NUMERO" />
</a>
</li>
</xsl:template>
<xsl:template match="/CHAMPIONNAT/JOURNEE">
<h2 id="{@NUMERO}">
Journee  N <xsl:value-of select="@NUMERO" />
</h2>
<table width="40%">
<xsl:apply-templates select="RENCONTRE" />
</table>
</xsl:template>
<xsl:template match="RENCONTRE">
<tr>
<xsl:choose>
<xsl:when test="@SCORED > @SCOREE">
<th align="right">
<xsl:value-of select="@DOMICILE" />
</th>
<th>
<xsl:value-of select="@SCORED" />
</th>
<td>
<xsl:value-of select="@SCOREE" />
</td>
<td align="left">
<xsl:value-of select="@EXTERIEUR" />
</td>
</xsl:when>
<xsl:when test="@SCORED &lt; @SCOREE">
<td align="right">
<xsl:value-of select="@DOMICILE" />
</td>
<td>
<xsl:value-of select="@SCORED" />
</td>
<th><xsl:value-of select="@SCOREE" />
</th>
<th align="left">
<xsl:value-of select="@EXTERIEUR" />
</th>
</xsl:when>
<xsl:otherwise>
<td align="right">
<xsl:value-of select="@DOMICILE" />
</td>
<td>
<xsl:value-of select="@SCORED" />
</td>
<td>
<xsl:value-of select="@SCOREE" />
</td>
<td align="left">
<xsl:value-of select="@EXTERIEUR" />
</td>
</xsl:otherwise>
</xsl:choose>
</tr>
</xsl:template>
</xsl:stylesheet>
