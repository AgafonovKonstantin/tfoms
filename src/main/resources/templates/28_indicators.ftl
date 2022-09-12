<#import "parts/common.ftl" as c>

<@c.autoupdate>
    <h4><b>28 indicators</b></h4>

    <#assign mass = []>
    <#list indicatorsEnts as ent>
        <#assign mass += ['${ent.status}']>
    </#list>

    <#if mass?size = 0>
        <form method="post" enctype="multipart/form-data" class="form-group mt-0">

            <label for="YEAR" class="form-label"></label>
            <input class="form-control" type="text" id="YEAR" name="YEAR">

            <label for="MONTH" class="form-label"></label>
            <input class="form-control" type="text" id="MONTH" name="MONTH">

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary mt-3">GET</button>
        </form>
    <#elseif  !mass?seq_contains('1') && !mass?seq_contains('0')>
        <form method="post" enctype="multipart/form-data" class="form-group mt-0">

            <label for="YEAR" class="form-label"></label>
            <input class="form-control" type="text" id="YEAR" name="YEAR">

            <label for="MONTH" class="form-label"></label>
            <input class="form-control" type="text" id="MONTH" name="MONTH">

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary mt-3">GET</button>
        </form>
    <#elseif mass?seq_contains('1') || mass?seq_contains('0')>
    </#if>

    <div class="card">
        <#if indicatorsEnts?? && indicatorsEnts?size <= 10>
        <#list indicatorsEnts?sort_by("date")?reverse as indicatorsEnt>
            <div class="card-body">
                <#if indicatorsEnt.status = 2>
                    <h5 class="card-title">Status: <span style="color:green">CREATED</span></h5>
                    <p class="card-text">Date: ${indicatorsEnt.date}</p>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <a class="card-text"
                       href="/28_indicators/${indicatorsEnt.filename}">${indicatorsEnt.filename}</a>
                </#if>
                <#if indicatorsEnt.status = 1 || indicatorsEnt.status = 0>
                    <h5 class="card-title">Status: <span style="color:#fcaa05">CREATING</span></h5>
                    <p class="card-text">Date: ${indicatorsEnt.date}</p>
                    <p class="card-text">Filename: ${indicatorsEnt.filename?replace("/","\\")}</p>
                </#if>
                <#if indicatorsEnt.status = 3>
                    <h5 class="card-title">Status: <span style="color:red">ERROR</span></h5>
                    <p class="card-text">Date: ${indicatorsEnt.date}</p>
                    <p class="card-text">Filename: ${indicatorsEnt.filename?replace("/","\\")}</p>
                </#if>
            </div>
            <div class="card-footer text-muted">
                Author: ${indicatorsEnt.authorName}
            </div>
        <#else>
            No message
        </#list>
        <#else>
            <#list indicatorsEnts[indicatorsEnts?size-10..*indicatorsEnts?size]?sort_by("date")?reverse as indicatorsEnt>
                <div class="card-body">
                    <#if indicatorsEnt.status = 2>
                        <h5 class="card-title">Status: <span style="color:green">CREATED</span></h5>
                        <p class="card-text">Date: ${indicatorsEnt.date}</p>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <a class="card-text"
                           href="/28_indicators/${indicatorsEnt.filename}">${indicatorsEnt.filename}</a>
                    </#if>
                    <#if indicatorsEnt.status = 1 || indicatorsEnt.status = 0>
                        <h5 class="card-title">Status: <span style="color:#fcaa05">CREATING</span></h5>
                        <p class="card-text">Date: ${indicatorsEnt.date}</p>
                        <p class="card-text">Filename: ${indicatorsEnt.filename?replace("/","\\")}</p>
                    </#if>
                    <#if indicatorsEnt.status = 3>
                        <h5 class="card-title">Status: <span style="color:red">ERROR</span></h5>
                        <p class="card-text">Date: ${indicatorsEnt.date}</p>
                        <p class="card-text">Filename: ${indicatorsEnt.filename?replace("/","\\")}</p>
                    </#if>
                </div>
                <div class="card-footer text-muted">
                    Author: ${indicatorsEnt.authorName}
                </div>
            <#else>
                No message
            </#list>
        </#if>
    </div>

</@c.autoupdate>