<#include "security.ftl">
<#import "login_parts.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">TFOMS RM</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/COVID">COVID</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/NAS">NAS</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/28_indicators">Indicators</a>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">User list</a>
                </li>
            </#if>
        </ul>
        <style>
            .navbar-text{
                text-transform: uppercase; /* Заглавные буквы */
            }
        </style>
        <div class="navbar-text mr-3"><b>${name}</b></div>
        <#if name != "unknown">
            <@l.logout/>
        <#else>
            <a href="/login" class="btn btn-primary" role="button" aria-pressed="true">Login</a>
        </#if>
    </div>
</nav>
