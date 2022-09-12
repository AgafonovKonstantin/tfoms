<#import "parts/common.ftl" as c>

<@c.autoupdate>
    <h4><b>Population registr loader</b></h4>

    <#assign mass = []>
    <#list nasEnts as ent>
        <#assign mass += ['${ent.status}']>
    </#list>
    <#if mass?size = 0>
        <form method="post" enctype="multipart/form-data" class="form-group mt-0">

            <label for="customFile" class="form-label"></label>
            <input class="form-control" type="file" id="customFile" name="file">

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary mt-3">Add</button>
        </form>
    <#elseif  !mass?seq_contains('1') && !mass?seq_contains('0')>
        <form method="post" enctype="multipart/form-data" class="form-group mt-0">

            <label for="customFile" class="form-label"></label>
            <input class="form-control" type="file" id="customFile" name="file">

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary mt-3">Add</button>
        </form>
    <#elseif mass?seq_contains('1') || mass?seq_contains('0')>
    </#if>

    <div class="card">
        <#if nasEnts?? && nasEnts?size <= 10>
            <#list nasEnts?sort_by("date")?reverse as nasEnt>
                <div class="card-body">
                    <#if nasEnt.status = 2>
                        <h5 class="card-title">Status: <span style="color:green">LOADED</span></h5>
                    </#if>
                    <#if nasEnt.status = 1 || nasEnt.status = 0>
                        <h5 class="card-title">Status: <span style="color:#fcaa05">LOADING</span></h5>
                    </#if>
                    <#if nasEnt.status = 3>
                        <h5 class="card-title">Status: <span style="color:red">ERROR</span></h5>
                    </#if>
                    <p class="card-text">Date: ${nasEnt.date}</p>
                    <p class="card-text">Filename: ${nasEnt.filename}</p>
                </div>
                <div class="card-footer text-muted">
                    Author: ${nasEnt.authorName}
                </div>
            <#else>
                No message
            </#list>
        <#else>
            <#list nasEnts[nasEnts?size-10..*nasEnts?size]?sort_by("date")?reverse as nasEnt>
                <div class="card-body">
                    <#if nasEnt.status = 2>
                        <h5 class="card-title">Status: <span style="color:green">LOADED</span></h5>
                    </#if>
                    <#if nasEnt.status = 1 || nasEnt.status = 0>
                        <h5 class="card-title">Status: <span style="color:#fcaa05">LOADING</span></h5>
                    </#if>
                    <#if nasEnt.status = 3>
                        <h5 class="card-title">Status: <span style="color:red">ERROR</span></h5>
                    </#if>
                    <p class="card-text">Date: ${nasEnt.date}</p>
                    <p class="card-text">Filename: ${nasEnt.filename}</p>
                </div>
                <div class="card-footer text-muted">
                    Author: ${nasEnt.authorName}
                </div>
            <#else>
                No message
            </#list>
        </#if>
    </div>
</@c.autoupdate>