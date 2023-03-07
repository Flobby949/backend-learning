<div style="display:flex;flex-direction: row;flex-wrap: wrap;width: 100%;justify-content: center;align-items: center;">

    <#list list as item>
        <div style="width: 240px;display:flex;flex-direction: column;justify-content: center;align-items: center;border: 1px solid #f6f6f6;margin: 30px">
            <img src="/img/${item.cover}" width="100">
            <br>
            <h2>${item.name}</h2>
            <br>
            <div>${item.des}</div>
        </div>

    </#list>
</div>