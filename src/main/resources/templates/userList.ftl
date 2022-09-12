<#import "parts/common.ftl" as c>

<@c.page>
<h4 class="pb-3"><b>User list</b></h4>

<table class="table">
    <thead>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Role</th>
        <th>Status</th>
        <th>Create Date</th>
        <th>Disactivation Date</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <th scope="row">${user.id}</th>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td>${user.active?string}</td>
            <td>${user.activationDate}</td>
            <td>${user.disactivationDate}</td>
            <td><a href="/user/${user.id}">EDIT</a></td>
        </tr>
    </#list>
    </tbody>
</table>
    <b><a href="/registration">ADD NEW USER</a></b>
</@c.page>
