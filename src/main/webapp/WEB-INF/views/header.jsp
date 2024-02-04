<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "sec" uri = "http://www.springframework.org/security/tags" %>
<!-- Just an image -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">



<nav  class="navbar navbar-expand-lg navbar-light">

<a class="navbar-brand" href="#">
    <img style="height: 50px; width: 40px;" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAilBMVEX///8AAAD39/f6+vr29vbw8PDt7e3z8/OlpaWZmZlWVlbi4uIhISGTk5MxMTFQUFA6OjpCQkJJSUlcXFyzs7MaGhrBwcGrq6vf398JCQmJiYksLCxLS0tkZGTo6OguLi5ra2t2dnbKysqAgIAeHh67u7vU1NR7e3vJyck+Pj4VFRWVlZVoaGifn5+lN9MlAAAYvElEQVR4nO1dC2OyOg+mF2BTBoI6ZaLivGyy7f//va9JCgKte2Fzt++Y857JOoh52jQt5SF1nKtc5SpXucpVrnKVq1zlKle5ylWaIkS/0/ES+zW/U5XDeynjSpHET8e4TAjexyqO/9lVOb1VibOqzkM/o0vAP1EibWiyqX/XLK2KO21V/RG2VXFUICQXiLAHSl+dKvFabH3BT6oAoeiuSlSqfEeSKqFVIcIeRqEqTlaRKgcdnT6Ub9FhN114NdfNJbioqcJq7KlKlJ2E8HAhSqtED1UcoJ1UgVWc2lVyCQi7q0JPBAWSq4oHF1A/sD3VJ1S76W/vqpINVWQVJ6t6AASElSofXEFiLUndDk4Pqxz6Ximo4Uo/4BTM1P9+T1VCYlOiiVikfVP0UsVJlUOqeOmdkkKP6Fvx4EeyREidmL5B9G5DQEPtRnghJmK4dnq3oRDaKkkIVc2Rl0KlyV6dB86WhAdDaqlKqEoXvAfEUpUgVXBcqlL/eB9VXAVAUlWFVPRM7JCiX9VjyKNgjhq0Kkl9Wzg9ql5QSKirAkfD0Rbd4lOq+CkUCtFrTMSIV7/8s6qcd1R11dRURb+3aqf7AFuP7VVQqAvvPB6aqlpWfEaVkL7rS67+95VI9V9XXS5cIHwV0n3fhV8cV+mA30CVVKo6OzxoguguhTJGqZICVWireqkCQ5QaNf3wfTx2YPxypSs8nys7PbejJiWucF2uTIKrXJ+7KsBABbnKLlWqyjprEvDdWpUnURVUlK+sUp+e18MqNadxXSF8D6xS+OBKX4vrcazJ7roUEBUCoMk4HNdUubK/KhUaqLV8CIWlKs/9gFWgSltVb3tj+txBapfUL+f9VYkvUtVr2v4fEvcnpd/98IfEi9hPSrz6coRPPwqQseWXIxz8MMLFlyMc/ycQLt5uf0Lewm9DmHz5t9hlcEV4Ebki/Eq5IryMXBF+pXw3wpckHG1pmvgQRVH8gof3cbGeqc9Nkg0GWXxDV20zffkwgSvmiQe/zLJwlM/1X/zoQR9NIjjnAN+yj7PBOMsi+sN3IxyMD/cRwzuwwWAymTzC0Z7dHCZ7OJhNFsvJ7ICneozd0+VzNgTrGdbM0+LwnDMNccKYvpu7xcnnI4PTZ5MNm8wmP4RQ1bnL9uUhyTI/nZrdlUezKNcz5iZCaNmC2t6JHhZ7OrodgVZECNemlcJvR7hVrkVtc0L4FJ6WHJIKYXL7zKjcRLh7wz9INt8M6Ozb8RuTvwThMF9TYfxy94AOuWLsrbxLrRC6yhOpsVsIE8d7YLTONAmcshZuE6d4+g0IxyxlBdk0Hm2fNtgPHX5bsGc6tUJ4EwonH+NhA+FWaSi7YfLgcEb97TZ27tnh8PMIVRuuRk9U+FA/JS+oFSuECUtTlmJbtb3UXcZ4imp7dQ7VgkLoLOPfgVAFwOrwJHPteCXCFbv3vCG5qWTQ1Pd0GfTDA0J2ZsxfeRMCDgg99vQ7EM4Z9r5TG4LPPbTa8AZtfaUGyhQqHuZ4jJGGXDODOhIMRlLohwD55xFm4KG7l/KrGQadEYt2ZT88atwhtvCe4Sg/D9iYJdR9N0f1IwLkQ2xaJ0eXfRmheo3whlXf/d0I5+BSQwwUwwMIHMnD/rEcL+Y04REHlz5oqVY+Tw76hNW8/OHrmQF+eKjT1Wd55dnXeeml5IrwK+VyCE+PF+3f0gPhe6p6irgcQq7JQ7YHN2Iz7YMQVZ15hsv7Pe5SOgZhlgxsf5M9HzIhFYgIKQZKsQ36ICROhUBVbZQWEtt7mgSMn8fRK9CBTFU9ERITCVFK4hzQE3Eo7IeQSyLFOESpaKjijuxDZ+DS2Y4YC2uqtCaswF7EQ+J3cM08QJIY8ueQHbHdseOms6rLyjZZl/2Qa54GUTXQRXo4fclRAh+VJXsHQQPCIInWg66SbweDp+02Hyw323ypDvN8+xSp49en5Xj7+rQdd1a12Y6DOMoiB4lvkmg7gqzijtuTsqYpfXiEJCLp+Joats2yXffnKGGmfqRhFrJFpu611IyOBVmRreFvRZYl3TWxEE6ejnJNGiRumEtWabpSrzYsXYC6S4lQzc+iOAq7mzWKUviIExZGBQsi1YkXURAhwiBK6KCjqgxVvZZWIe3JJWAldbA7Ql81vCR0xLBE6hlwY1+SIOwBUbVhHKa7KAZgjGVxWsSqKNkVx8Uumo6iRXeESZGEafGGQRj7jSRyGIcjvw9V0KEISkS/ks8gaUxzd8qmUT4YneQ4xe8//Y5Gh0f8ZZwfl/lmnBQsfc03oyxXkozifBBF68UmCcda1RErbXGsqQmgZH0qGefTYxRFUtMgkVOsRwlONOUekQYZecT65VzUjtUd7y5lD83TYwBU+/0WTGuQfDasPReJd4W+odfigws2FB9AzU295IUVAd5Bas5g3UJRkuF6ieWKEXztsFE0Zy3bIgMPlIwaJVArcaMkbJcICGjHesmKGZo/KNxHdrUP/Y77Pv4kUv4jK9J06XCv5hDYZIfa5dAaZfv4MHlwRuuwyBzuwi9Ac+awipWGSLn1dIR4BTUNM3IoOVEvpK9K0mL6DC7qI/ld6vaDwVAVet3JkNJ3XWUK8LeQwIUqfVc6ebpes2e34fAwHgQ1XhbW9G1pFpeu6xxZkG5Age+CWdKXebAoEul5fhUB3wzv2EPJ5FTv0n9M0wXLBVrlqmiIJnLhceDRdcenzHJ97jvC94jeB/xy11VK/GGwW++Ost6CsGDPWF4reIQCvXrtILXQmS6CYKuMgoEaVLr+Ngh2R6zA8rJ7uOy5UdFQciKXqKuUuxeLYE5WoSqlwZcecum8fsMF9/EDu6KUZZe8Ywvo6o3KmtQBgdw0nAt8SZmqw5Mv9UQSggY0/EkV1tRbwwzwjukpZCmHnFWaHJ9rA8HT/b4vsZwRjuNAq6rgjjj1agW50aHcut+SYDV4jaJmi4HMoOi+XiIKAN2Du99T9u2o6WhXatyzxe0QSD1z1ijClp83iiL7dU+Nortm37y0JKZZznN71HJhAtBYIKbxpGnWvh2AHedBlRRN1hqOtA3vGzKjHi4oaOi4VfjUDOn6rMZATWN3w9uoYh4bRRMT9J1Z9GoWXU5yI9opJ120B2FL61jgHExdlpbGs+4aRY9md72YYLxYtwpNG8DZWDMW3JvePTSb1WeGe4vQmAzRrOprKJhvpvvZ/GgJRjUj9940yrVEjNjsBBvzypnZrhcSgbdy7UEHJzT1QnTbvHnSjWWQMQcQhLNrnnZvRmG8MvgAKf2fsjedSMfzRqFnqeI7Y4QkO1sDz63ZYBKKouZpD181YAwsQ4VlTH40O5izPYOwtaD1bLkU2azN1y2wC2fOxQUjnbEaCwYUjanJm6UiIAinzSJnZ4bEocVzJxbUy68ZMDaWr3K4GbrhvKA1rRpbgvDRrDAeml0YI1Kr7NFS9nnBDhG240zr/gZkbXEhmI+1F5EHlvOgbNoqg3nUohVXRqbrfl4wHL61S1v3qCBQ8tQ6LbYM0nBpe/a1tURr4/66NKblzp8WvKsY+i0pcOyrFciDLdCNzKiCaNo+YZkOUee0zfaDS8A6CY5LneVu0pAZRJVxs2wC4WJ60yzDUWVruThslu1hFG7ck35efvoVBJtYH7N9VFY/jcYq7cH5M3L702Cs0g5onxBcudzdzJoyQde9bZS9QFHxXRAvN2BYp6Q0zAXNcIiD8WQ1bMj+fGGzbIgzmFnzzBUNVK1CrEpj9PqwwHhmej1ON1qDQHOdTQvON9uzLMsNop62twc6vG98tZ3Znh18WHCMMyOXOeu2rbM5em7Zho0mztqnQqFxAw/TmqK9vrax1dBH5Ywyc9ZNxhjTfsvKofYAw81AZ9wuxOtbqydn7gQ+Jh48hyiMYnMZUZld2Drsiy0qoO8Zt+oPtsowb0JBbAt/H5Q3e6e23X7Pra4HZqdtL5M7m9mW9TaHZn0j66zfDH8fEFwNYuYy88bSu+wGwoLjwuDlhGacOldFlkVFvVxykQHj3l5XAh7Rhq1Cq5PRbYTxVAG8LG8Xuqntyw62EEvTEKM2PiADa7vQt760CsdWLDDJjtqFeG57eZlwG/FDQnMZLKVLPS9dnYlZW0tHx3Ztj1y0HmdiebWFTRpujDraWKPKxl7374i0PYDDUG3eqLhFGi9SzcsrBcMr3MuJerIHnloR4moLnUZZdlAV+nljeRxUYVQxpqGWFXHMudOyqiZWYtjSHmfuWDAYLcm4Sp8ov7LxMA8NsfdD3QJc05uUmlnRHvOhFANQiz6gJDDdgOv8bjWr6rnfNE3M0GIu3YHvFqq5kHpHaeSUlXpdnohUlSpsFvt4qIOK8DEVFDySxxtedihz52iyC07xzL6SmwO1cMvEXD5QbJySLSV1nigh2xB56XhNUSNUOgi2xPJAzVhjqsfttppwxrUqXMMyVzb0qgFx3CkjHWh6yAYhC5/IKofyRKk6xJmxMUF4M6uupqq0ShKZVNoB2h7f6spLoyB3sMtBFjrMH+c87KZRskJ0smTNbghK6/kKzeZ1XBJlxjbujUdBcYyCO6fM9SWAO3Ogk9tPTW5MhNo7IcMeJbcj3yzztTmaC1W/wtaGaHQaLXbELdJuoe6dsuMog5rGp/+1ejarqVFMTg1O8JasWZqN4CtF6R1O6ehGK4IdacvnnDLVopmRjnQZMcgc2D2q/jRaQ4zlJ4R7FscKYTkKI0lswyp5ONki7k7FuetUWGYMqHyAkG3nJxrD4XR2XIuzc4tvnDLS8Sojnc6HydHfTYho4na4KuWwpa86FtEiPE6GK2849FT58JCzMFoE0XE6zUb5Ms7z40gzD8elp5aiPXRJn+tkE42XSfw6VtV2ZPkmWUxVTY0243iwPL6OwzhRA85TSRcslYQW10BKntAZ6XjJdeOn3JfE2WxIrf7qMhbLaB0kSZao4LfIoikLs0EEJOVooKxMYlZkiV7OWHvCRrIMuKuhTlXNxFGUBMBlXLreMhkA/THMIqUxObJdlKVT37MyIv02Ql5mpOOa3lzmfqMOZRkTlza9uZ7sFAVyPlP4KKbqxz5VZeo41YXQ2mp67pkQF6uTw1eXM5y6SL14mU5LVSnMAvzcNMSYi5yIhg5Rwgx6noGQmzzeAkP/o/4lPf0hWjluu0YoOIiHVvGWvuc2bRaP6W5l0qKdrmnK9hi3DDl7k19DIYCWxYGlpyI+B0abcfJdU+3ozacL57kybwpNphpA/Uj26nLhPN69LlHyfPm0r9StZptlKZuban7i77fL15xKN28Hgdww1ZvuH6qzl9t9lc/s8JYvXyH6Fa/LzcR8EixcSXCkkNIFaDgV8aUr3Hcy0sGi2npC64X7eVk9aiozf57Nbm5msM442Q8huR2SBsE5pPV9lLM1TsMOpJ+TYA3NP8pRsp1xD5y4feNWavI5ZKSTfpmRTgAhzkUCnOsCRGsuLUBo3AZAbjvMhCpKQjgkAcMEg1phd4CUOk66lNhQ1DLSQcUbGeneQ+hSbjwwQcFsvKAgzycKsyIEAerdfPaQL8f5w2xYXd9UJbskKfNW+IFsw9XKr8pXw8Zp8l8Isb5Ox10T2p1F6MwfakFy9GKjuRy6c9X/Lbv9vxF+RM4hHL62LXgyXbPHqwsdpHC/E6H1eU37HkJe+CnG6vsQ8ipxWzFKklE1rm1aU+HpX0Xo6sF3cXcAgrVYPW51a40bEBHh4CLZz5bfilBogJMaHK5viRqLEIjwMjS02bcipLnZa2uA0Vkj6/eTF0R4850IsTpthm/wD7XHKH8UoW80VSU4gNRoJH8UId4F2x9tCbznOy22/02E+Lzt3EMRvGU+8fT+JsL3abqbRk/8mwjxFtx4xFQKNmK1BP8nEWKcyc+fDpPx6pnQn0RoeW2gIXelJSB/EiE+6d08nJUGh/dPIqzWq9+TMtT8SYSdWG7lKtgVYQ/52wh94/GnKd+LMH3nzaN5f4Sz9iRwtn00TvrLCHGSVB9/YP2+zfP6ywjpXqxGjcEbFIOZ8HcREsDaUyR6AtN+Te4HEPqWTQTgqXVPhAQwOFXZa6WpKd+PsP04qfS1fggJ4OIUS88B/AGE1ieL254ICeCu3YK292C/H6Gx4v0BhASw1qvzswC/ca2tjnBxdxJkyj60EMopO7OiUxndpQ+CYBuCN38eIW5fJ075XuoIBW8gbHAOLQiFv2NB+GZN6SDI5noffKcFHaHuaYLRStlmIjSTwb0vlG4PNxDEK+sIebMNG4QwG0JnsY7iN2tGOnGP6z1Flz4Imu7ZKEpWyqp8kbYR9s1Ih09gcXs9vPIdhP9sQ7eIYvRSbrTjJA5sQcbuog6k/chiBk8pN9lnEXJMzlZuLsud1zgJY40bEC7ioEQY3tTEgpDLaZKlD6UqQc6P2zjOWBSwcHCijebvAgQvzbJ0qLBskzgeOSdVJeWyx+ZlejdJrlNObUfH7FWzn5TnzpKwcywVzm6aJTeOVkUbPyKz7n63i4Ljsj0OvpMuYc+CLFoJQDgahUQ3oyfsnPfM9SX0VpBEmxJQuYtNlb3NmUy7j4dCBCyd3ji8+g/TyEELQr62QadhokKIYVc6mwRI0chBdInw9IGMdE49I52CUmzKxGEKYUEItzaEN22EO3RdcUqUJx0PU+moFhmfHvi/3wcrhMiF3iSputnSGelKq3pmpOPEcyP/djYsHW3IvYBlOUsWiHCVmQDh4WEL4ShAhJz2WAb/92FNNdwVr/PKrn+3ICA8BgqhsiebslGpSlA/dHsl3RNEr6U9Z9W/bZJFY11ZSuVtGC1otXDVFspn3fTSJIpvSlakTm4nJnE2CNdutRPuoQNAhTCJEg98KstiiqVSJxWkjHQ9NtWF+ETJWZEjNliHRaxzYeKIv1gUHe+ehD9lweKWtGL6TFT7WKzTYnjaghtfb1u+P2qDZwdrGC3GLAzDUpW2CllKH04V9QX3h5P4taEh6pBD4IIzb9wNG3J84Rgm1dcHu9gRZULUW5buurYhd6eQnQv28xRAWMd0o+WGr6iS0qyJZ3NdpiXiDXZSGCp7xmxajBzKVCmqiCh494xtuA2rBEEel1Aa0zEQsSTmWrvdFZ3bkHujxU4hlMjDgs1TJe1aC4RBoJ517zviplgs2FwNqq9BEBy5Lzgp4qDXg9R0nXUhlw8z0mF2OzVa7NIB/IrMM3mbLjojlN4oDRVCDwldqs4wRx2qUkA9z+2Rr/KtCBRC3xN5sJsegTkI9e1J3j8jHYRfn1jDGJLHrEgzDMvcU1FZeWlnhOreoghUP9SqaPNtOvJcUeZN7iYzNg0Y3FsslQEjPfSQKr+nKjStdlyLNFD8iUjzqbx4f3etratcEX5CrghbckX4Ubki/IRcEbbkivCjckX4CflvInznjZjVFyH83iczbDA+J8uBgTC6vfu8vHwfk70/2+SC8gsR/sU3Sh67WFI9jrjsW0E7/zsQOrMs+Ydkp5c756NdcCnZhUiy+b43uzpKl7fzOgqtEfw6hBeXK8L+gtuqzG5+i8yOX4Lwt8llEVqeov24tDMvf042Pw3HImZaps/I6vjTeAwJL5meVYnwfptcYlOZq1zlN0o7wcb7ArQD2j7SIl2zNTRVWTvXx6yy99N+T+Awn5dDeUmMxJb9HqMJvQMht6nqtw8ur6kSpYbqw5qR7rxZmEaOGH6SGEaVqkZGuo+rEuX2i31UEe8HVCFlhph5OtOgNWHbeV3VrrX0W7W3MRHq9B+7qiKmoHNSJUtVlJasr1VlFREFkVOiNiT3dfeJasNZ2PFX4o6ZxEuVWFF+n4qv9q6VmLsH/V+r4vRkvKsqXrOKmDbac6XOodOjJ1JiMNIodTPQtpnkYz1VlQ2vVUli5JFVfUgWpSpNOqwy0pXZ7XqZdWKGnbLbEU+2N0KhrSOEvHRVbVUvhFrVKSMdUMI4tip5aQ/XwrFC8zsF7UIM6fu4PuirijI4alWEliP/rJ+XllZRRjpBFa9Jef0iDdd7r1NCNL3rqa53v5b7siNC+KR9FikUaFXIO+xlVX0bXE18w3SJXO8WzzuHGnHi4Qkiz+lsd1UiuA+qEk1VH7JKnFR1vPA9nZ9X8cWqcMdYRzNmVVc8m0mgrcNFL4fsYwKyvQGdlTdUdc5nBsM0qXL03rXC5+Vo2FOVS8RaCQMNWQVbtMKGrK4v+yVZcyD3Gxc+7uMKRDg0EVlr8Jc+qiA9nitJlYfbw5JVwMnjfVO/gVWwyWxllYNp3zCFnIQ8dd0DINSJqi2PEtDBqwBAZERV8GFP33fGLAVEq1KXQ0hHLh6qkucyAZ6zCnYz9okpiFYR/Q3In57oN/cG53HKaSi+7FBT1Y9Ip9+V0DNaXlPlfkaVgwTEq1zlKle5ylWuYnl1SclXbEX7c3J/v39+Pjw+6n/q8HnfIZPKH5J7JfP54XE4PMznw8NQHe+/Zk/onxJAeP+o5P758fn5+f7x+f7/DCHcW8uWXB9dXeVXyf8AG/2bXhe9ymsAAAAASUVORK5CYII=" width="30" height="30" alt="">
  </a>
  
  <a class="navbar-brand" href="/Restaurent/index">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
   <sec:authorize access='hasRole("ADMIN")'>
      <a class="navbar-brand" href="/admin/profile">Your Profile</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  </sec:authorize>  
  
   <sec:authorize access='hasRole("user")'>
      <a class="navbar-brand" href="/admin/profile">Your Profile</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  </sec:authorize>
  
  
   <sec:authorize access='hasRole("ADMIN")'>
    <a href="/admin/get"><button class="btn btn-info">Show Food Items</button></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
    </sec:authorize>
  
  <sec:authorize access='hasRole("user")'>
   <a class="navbar-brand" href="/user/get">Show Food Items</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  </sec:authorize>
  
   <sec:authorize access='hasRole("user")'>
   <a class="navbar-brand" href="/user/api/addtocart/viewCart/0">ViewCart</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  </sec:authorize>
  
  
 
  
</nav>


