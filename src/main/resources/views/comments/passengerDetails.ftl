<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style>
        :root {
            --background-color: #2c3e50;
            --border-color: #7591AD;
            --text-color: #34495e;
            --color1: #EC3E27;
            --color2: #fd79a8;
            --color3: #0984e3;
            --color4: #00b894;
            --color5: #fdcb6e;
            --color6: #e056fd;
            --color7: #F97F51;
            --color8: #BDC581;
            --a_border_color: #86a3b3;
            --h2_border_color: #8ea2b8;
            --a_hover_background_color: #86a3b3;
            --font_color: #e8f6fd;
        }

        * {
            margin: 0;
            padding: 0;
        }



        body {
            width: 100vw;
            height: 100vh;
            background-color: var(--background-color);
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: 'Montserrat', sans-serif, Arial, 'Microsoft Yahei';
        }

        .card {
            /* flex布局下元素不按比例缩放 */
            flex-shrink: 0;
            flex-grow: 0;
            position: relative;
            width: 360px;
            height: 500px;
            overflow: hidden;
            margin: 20px;
            background-color: var(--border-color);
            border-radius: 20px;
            display: flex;
            justify-content: flex-start;
            align-items: center;
            /* flex 子元素 纵向排列 */
            flex-direction: column;
            /* 增加个阴影 */
            box-shadow: 0 0 30px #2c2c2c;
            /* 同意给字体价格颜色 */
            color: var(--font_color)
        }

        .photo {
            position: absolute;
            /* 默认为放大 */
            width: 100%;
            height: 100%;
            top: 0px;
            border-radius: 0%;
            overflow: hidden;
            transition: 0.5s;
        }

        .photo::before {
            /* 通过before增加渐变背景实现遮罩，让文字默认看起来清晰一些 */
            position: absolute;
            content: '';
            width: 100%;
            height: 100%;
            background-image: linear-gradient(to top, #333, transparent);
        }
        .card:hover .photo::before{
            /* 缩小时隐藏 */
            display: none;
        }

        .photo img {
            /* 图片高宽均为100% */
            /* 然后按照cover缩放，裁切长边 */
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .card:hover .photo {
            /* 鼠标移上变小 */
            width: 120px;
            height: 120px;
            top: 30px;
            border-radius: 50%;
            box-shadow: 0 0 20px #111;
        }

        h1 {
            color:#fff;
            position: absolute;
            top: 30px;
            transition: 0.5s;
        }

        .card h1 {
            position: absolute;
            top: 30px;
        }

        h2 {
            margin-top: 75px;
            width: 80%;
            font-weight: normal;
            font-size: 13px;
            text-align: center;
            margin-bottom: 20px;
            padding-bottom: 20px;
            border-bottom: 1px solid var(--h2_border_color);
        }

        p {
            width: 90%;
            /* 段落缩进2个字符大小 */
            text-indent: 2em;
            font-size: 16px;
            margin-bottom: 10px;
            line-height: 30px;
        }

    </style>
</head>
<body>
<div class="card">
    <h1>${(passenger.name)!}</h1>
    <h2>联系电话:&nbsp&nbsp;${(passenger.contactphonenumber)!}</h2>
    <p>
        性别:&nbsp&nbsp; ${(passenger.genderName)!} <span style="margin-left: 50px;"></span>民族: &nbsp&nbsp;${(passenger.nationName)!}
    </p>
    <p>
        出生日期:&nbsp&nbsp;${(passenger.birthdate)!}
    </p>
    <p>
        证件号码:&nbsp&nbsp;${(passenger.papersnumber)!}
    </p>
    <p>
        发证机关:&nbsp&nbsp;${(passenger.licenceissuingauthorty)!}
    </p>
    <p>
        证件类型:&nbsp&nbsp;${(passenger.papersName)!}
    </p>
    <p <#if (passenger.passengerLevelName)=="">style="display: none" </#if>>
        旅客级别:&nbsp&nbsp; ${(passenger.passengerLevelName)!}
    </p>
    <p <#if (passenger.profession)=="">style="display: none" </#if>>
        职业:&nbsp&nbsp;${(passenger.profession)!}
    </p>

    <p <#if (passenger.remarks)==""> style="display: none"</#if>>
        备注:&nbsp&nbsp; ${(passenger.remarks)!}
    </p>


</div>
</body>

</html>