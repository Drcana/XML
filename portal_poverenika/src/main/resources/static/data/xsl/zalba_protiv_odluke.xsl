<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="2.0" xmlns:zpo="http://www.ftn.uns.ac.rs/zalba_protiv_odluke"
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
                <p class="all_bold">ЖАЛБА ПРОТИВ ОДЛУКЕ ОРГАНА ВЛАСТИ КОЈОМ ЈЕ <u>ОДБИЈЕН ИЛИ ОДБАЧЕН</u> ЗАХТЕВ ЗА
                    ПРИСТУП
                    ИНФОРМАЦИЈИ</p>
                <p class="field_above_post_address">Повереникy за информације од јавног значаја и заштиту података о
                    личности
                </p>
                <p class="field_post_address">Адреса за пошту: Београд, Булевар краља Александрa бр. 15</p>
                <p class="all_bold font-11 margin_top_bottom_zero">Ж А Л Б А</p>
                <p class="center_text">
                    <span>
                        <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:podaci_o_zaliocu/zpo:naziv"></xsl:value-of>
                    </span>
                    <span>
                        <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:podaci_o_zaliocu/zpo:adresa/types:ulica">
                        </xsl:value-of>
                        <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:podaci_o_zaliocu/zpo:adresa/types:broj">
                        </xsl:value-of>
                        <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:podaci_o_zaliocu/zpo:adresa/types:mesto">
                        </xsl:value-of>
                    </span>
                </p>
                <p class="center_text">Име, презиме, односно назив, адреса и седиште жалиоца</p>
                <p class="center_text">против решења-закључка</p>
                <p class="center_text margin_top_bottom_zero">
                    <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:resenje/zpo:naziv_organa"></xsl:value-of>
                </p>
                <p class="center_text margin_top_bottom_zero">(назив органа који је донео одлуку)</p>
                <p class="margin_top_bottom_zero">Број
                    <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:resenje/zpo:broj_resenja"></xsl:value-of> од
                    <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:resenje/zpo:datum"></xsl:value-of> године.
                </p>
                <p class="indented">Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми са
                    елементима одлуке) , супротно закону, одбијен-одбачен је мој захтев који сам поднео/ла-упутио/ла
                    дана
                    <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:detalji_zalbe/zpo:datum"></xsl:value-of> године
                    и тако
                    ми ускраћено-онемогућено остваривање уставног и
                    законског права на слободан приступ информацијама од јавног значаја. Oдлуку побијам у целости,
                    односно у
                    делу којим <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:detalji_zalbe/zpo:razlog_zalbe">
                    </xsl:value-of> јер није заснована на Закону о слободном приступу
                    информацијама од јавног значаја.
                </p>
                <p class="indented margin_top_bottom_zero">На основу изнетих разлога, предлажем да Повереник уважи моју
                    жалбу,
                    поништи одлука првостепеног органа и омогући ми приступ траженој/им информацији/ма.</p>
                <p class="indented margin_top_bottom_zero">Жалбу подносим благовремено, у законском року утврђеном у
                    члану 22.
                    ст. 1. Закона о слободном приступу информацијама од јавног значаја.</p>
            </div>
            <div class="split">
                <p>У <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:mesto_i_datum/types:mesto"></xsl:value-of>,
                </p>
                <p> дана
                У <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:mesto_i_datum/types:datum"></xsl:value-of>
                    године</p>
            </div>
            <div class="right_align">
                <p class="margin_top_bottom_zero">
                    <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:ime">
                    </xsl:value-of>
                    <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:prezime">
                    </xsl:value-of>
                </p>
                <p class="margin_top_bottom_zero">Подносилац жалбе / Име и презиме</p>
                <p class="margin_top_bottom_zero">
                    <xsl:value-of
                        select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:adresa/types:ulica">
                    </xsl:value-of>
                    <xsl:value-of
                        select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:adresa/types:broj">
                    </xsl:value-of>
                    <xsl:value-of
                        select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:adresa/types:mesto">
                    </xsl:value-of>
                </p>
                <p class="margin_top_bottom_zero">адреса</p>
                <p class="margin_top_bottom_zero">
                    <xsl:value-of
                        select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:drugi_podaci_za_kontakt">
                    </xsl:value-of>
                </p>
                <p class="margin_top_bottom_zero">други подаци за контакт</p>
                <p class="margin_top_bottom_zero">
                    <xsl:value-of select="/zpo:zalba_protiv_odluke/zpo:podaci_o_podnosiocu_zalbe/types:potpis">
                    </xsl:value-of>
                </p>
                <p class="margin_top_bottom_zero">потпис</p>

            </div>
            <div>
                <strong>Напомена:</strong>
                <ul>
                    <li>У жалби се мора навести одлука која се побија (решење, закључак, обавештење), назив органа који
                        је
                        одлуку донео, као и број и датум одлуке. Довољно је да жалилац наведе у жалби у ком погледу је
                        незадовољан одлуком, с тим да жалбу не мора посебно образложити. Ако жалбу изјављује на овом
                        обрасцу,
                        додатно образложење може посебно приложити. </li>
                    <li>Уз жалбу обавезно приложити копију поднетог захтева и доказ о његовој предаји-упућивању органу
                        као и
                        копију одлуке органа која се оспорава жалбом.</li>
                </ul>
            </div>
        </body>

        </html>
    </xsl:template>
</xsl:stylesheet>