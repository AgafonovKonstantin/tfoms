<#import "parts/common.ftl" as c>

<@c.autoupdate>
    <h4><b>Covid registr loader</b></h4>

    <#assign mass = []>
    <#list fileEnts as ent>
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
        <#if fileEnts?? && fileEnts?size <= 10>
            <#list fileEnts?sort_by("date")?reverse as fileEnt>
                <div class="card-body">
                    <#if fileEnt.status = 2>
                        <h5 class="card-title">Status: <span style="color:green">LOADED</span></h5>
                    </#if>
                    <#if fileEnt.status = 1 || fileEnt.status = 0>
                        <h5 class="card-title">Status: <span style="color:#fcaa05">LOADING</span></h5>
                    </#if>
                    <#if fileEnt.status = 3>
                        <h5 class="card-title">Status: <span style="color:red">ERROR</span></h5>
                    </#if>
                    <p class="card-text">Date: ${fileEnt.date}</p>
                    <p class="card-text">Filename: ${fileEnt.filename}</p>
                </div>
                <div class="card-footer text-muted">
                    Author: ${fileEnt.authorName}
                </div>
            <#else>
                No message
            </#list>
        <#else>
            <#list fileEnts[fileEnts?size-10..*fileEnts?size]?sort_by("date")?reverse as fileEnt>
                <div class="card-body">
                    <#if fileEnt.status = 2>
                        <h5 class="card-title">Status: <span style="color:green">LOADED</span></h5>
                    </#if>
                    <#if fileEnt.status = 1 || fileEnt.status = 0>
                        <h5 class="card-title">Status: <span style="color:#fcaa05">LOADING</span></h5>
                    </#if>
                    <#if fileEnt.status = 3>
                        <h5 class="card-title">Status: <span style="color:red">ERROR</span></h5>
                    </#if>
                    <p class="card-text">Date: ${fileEnt.date}</p>
                    <p class="card-text">Filename: ${fileEnt.filename}</p>
                </div>
                <div class="card-footer text-muted">
                    Author: ${fileEnt.authorName}
                </div>
            <#else>
                No message
            </#list>
        </#if>
    </div>
</@c.autoupdate>