<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="2.0" xmlns:zpc="http://www.ftn.uns.ac.rs/zalba_protiv_cutanja"
                xmlns:types="http://www.ftn.uns.ac.rs/types">
    <xsl:template match="/">
        <html>

        <head>
            <style>
                .center {
                    margin: 0;
                    position: absolute;
                }

                p,
                ol,
                li {
                    font-family: 'Times New Roman', Times, serif;
                    font-size: 11pt;
                }

                .center_text {
                    text-align: center;
                }

                .field_above_post_address {
                    font-weight: bold;
                    font-size: 12pt;
                    margin-bottom: 0pt;
                }

                .field_post_address {
                    margin-top: 0pt;
                }

                .all_bold {
                    font-weight: bold;
                    font-size: 10pt;
                    text-align: center;
                }

                .font-11 {
                    font-size: 11pt;
                }

                .font-12 {
                    font-size: 12pt;
                }

                .margin_top_bottom_zero {
                    margin-top: 0pt;
                    margin-bottom: 0pt;
                }

                .indented {
                    text-indent: 40pt;
                }

                .right_align {
                    text-align: right;
                    margin-right: 10%;
                }

                .split {
                    float: left;
                }
            </style>
        </head>

        <body class="center">
            <div>
                <p class="all_bold">ЖАЛБА КАДА ОРГАН ВЛАСТИ НИЈЕ ПОСТУПИО/ није поступио у целости/ ПО ЗАХТЕВУ ТРАЖИОЦА
                    У
                    ЗАКОНСКОМ РОКУ (ЋУТАЊЕ УПРАВЕ)</p>
                <p class="field_above_post_address">Повереникy за информације од јавног значаја и заштиту података о
                    личности
                </p>
                <p class="field_post_address">Адреса за пошту: Београд, Булевар краља Александрa бр. 15</p>
                <p>У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја подносим:</p>
                <p class="all_bold font-11 margin_top_bottom_zero">Ж А Л Б У</p>
                <p class="center_text margin_top_bottom_zero">против</p>
                <p class="center_text">
                    <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:informacije_o_zalbi/zpc:naziv_organa">
                    </xsl:value-of>
                </p>
                <p class="center_text">( навести назив органа)</p>
                <p class="center_text margin_top_bottom_zero">због тога што орган власти: </p>
                <p class="all_bold font-11 margin_top_bottom_zero">није поступио / није поступио у целости / у законском
                    року
                </p>
                <p class="center_text margin_top_bottom_zero">(подвући због чега се изјављује жалба)</p>
                <p>по мом захтеву за слободан приступ информацијама од јавног значаја који сам поднео том органу дана
                    <span>
                        <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:detalji_zalbe/zpc:datum"></xsl:value-of>
                    </span> године, а којим сам тражио/ла да ми се у складу са Законом о слободном приступу
                    информацијама од
                    јавног значаја омогући увид- копија документа који садржи информације о /у вези са :</p>
                <p>
                    <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:detalji_zalbe/zpc:podaci_o_zalbi">
                    </xsl:value-of>
                </p>
                <p class="center_text ">(навести податке о захтеву и информацији/ама)</p>
                <p class="indented margin_top_bottom_zero">На основу изнетог, предлажем да Повереник уважи моју жалбу и
                    омогући
                    ми приступ траженој/им информацији/ма.</p>
                <p class="indented margin_top_bottom_zero">Као доказ , уз жалбу достављам копију захтева са доказом о
                    предаји
                    органу власти.</p>
                <p class="indented margin_top_bottom_zero"><strong>Напомена:</strong> Код жалбе због непоступању по
                    захтеву у
                    целости, треба приложити и добијени одговор органа власти.</p>
            </div>
            <div class="right_align">
                <p class="margin_top_bottom_zero">
                    <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:ime"></xsl:value-of>
                </p>
                <p class="margin_top_bottom_zero">
                    <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:prezime"></xsl:value-of>
                </p>
                <p class="margin_top_bottom_zero">Подносилац жалбе / Име и презиме</p>
                <p class="margin_top_bottom_zero">
                    <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:potpis"></xsl:value-of>
                </p>
                <p class="margin_top_bottom_zero">потпис</p>
                <p class="margin_top_bottom_zero">
                    <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:adresa/types:ulica">
                    </xsl:value-of>
                    <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:adresa/types:broj">
                    </xsl:value-of>
                    <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:adresa/types:mesto">
                    </xsl:value-of>
                </p>
                <p class="margin_top_bottom_zero">адреса</p>
                <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:podnosilac_zalbe/types:drugi_podaci_za_kontakt">
                </xsl:value-of>
                <p class="margin_top_bottom_zero">други подаци за контакт</p>
            </div>
            <div>
                <p>У <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:mesto_i_datum/types:mesto"></xsl:value-of>
                    <xsl:value-of select="/zpc:zalba_protiv_cutanja/zpc:mesto_i_datum/types:datum"></xsl:value-of>године
                </p>
            </div>
        </body>

        </html>
    </xsl:template>
</xsl:stylesheet>