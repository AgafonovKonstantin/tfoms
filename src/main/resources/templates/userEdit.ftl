<#import "parts/common.ftl" as c>

<@c.page>
    <h5>User editor</h5>
    <form action="/user" method="post" class="form-group mt-3">
        <div class="form-group">
            <input class="form-control" type="text" name="username" value="${user.username}">
            <div class="form-check form-check-inline mt-2">
                <div class="innerCheckBox">
                <#list roles as role>
                    <label class="mr-2"><input class="form-check-input mr-2" type="checkbox"
                                               name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}
                    </label>
                </#list>
                </div>
                <label class="mr-2"><input class="form-check-input mr-2" type="checkbox"
                                           name="isActive" ${user.active?string("checked", "")}>isActive</label>
                <input type="hidden" value="${user.id}" name="userId">
                <input type="hidden" value="${_csrf.token}" name="_csrf">
            </div>
            <div class="form-group">
                <button class="btn btn-primary mt-1" type="submit">Save</button>
            </div>
        </div>
    </form>
</@c.page>
