<#import "parts/common.ftl" as c>
<#import "parts/login_parts.ftl" as l>

<@c.page>
<div class="mb-1">Add new user</div>
${message?ifExists}
<@l.login "/registration" true />
</@c.page>
