Burepoda patika.dev in düzenlemiş olduğu ve a101 şirketinin sponsor olduğu practicum final projesi yer almaktadır.
Bu proje bir test senaryosu içermektedir.
Test aşamasında Junit, POM mimarisi, log4j teknolojileri kullanılmıştır.
Test iki kısımdan oluşmaktadır. Ve senaryolar şu şekildedir.

1. Kullanıcı girişi yapılarak sepete ürün eklenmesi

Kullanıcı Hepsiburada.com sitesini ziyaret eder.
Kullanıcı giriş işlemi yapılır.
Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır
Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.

2. Kullanıcı girişi yapılmadan belirtilen ürünü sepete ekleme

Kullanıcı Hepsiburada.com sitesini ziyaret eder.
Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.

Testin sonunda log dosyası oluşturulmuştur.
