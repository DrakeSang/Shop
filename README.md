# Shop
Ecommerce

The database used is MySQL. You can use MySQL Workbench and create new connection name localhost, hostname 127.0.0.1, port 3306, username and password root. In application properties file the db settings are described and they can be changed. They are used so when you start the app it creates the db and the table by using liquibase and db settings from the application.properties file. In the datasource url it is the name of the connection, then the port , then name of the db to be created and the username and password to connect to the database.

For the requests the endpoints are and you can test them using postman:

1) Product API responsible for CRUD operations on the products(create, update, delete, get single product)

create product: http://localhost:8080/api/v1/products/create 
Type: POST
json body: 
{
	"name": "RAZER OROCHI V2",
	"category": "Mouse",
	"description": "Introducing the Razer Orochi V2—a compact, ultra-lightweight wireless gaming mouse with the longest battery life that’s second to none. Armed with both Razer HyperSpeed Wireless & Bluetooth modes, it’s your perfect companion for gaming on the go.",
	"quantity": "15",
    "createdAt": "2020-07-15",
    "updatedAt":"2020-07-15"
}

update product: http://localhost:8080/api/v1/products/update/{id} (id the id of the product to be updated)
Type: PUT
json body:
{
	"quantity": "18"
}

delete product: http://localhost:8080/api/v1/products/delete/{id} (id the id of the product to be deleted)
Type: DELETE

get single product: http://localhost:8080/api/v1/products/get/{id} (id the id of the product)
Type: GET

2) Inventory api for listing products by given criteria(name of column the products to be sorted by and direction type) with pagination

list all products: http://localhost:8080/api/v1/products
Type: POST
json body:
{
	"orderByColumnName": "name",
    "orderDirection": "DESC",
    "pageNumber": 0,
    "pageSize": 2
}

3) Purchase api for purchasing product from the shop

purchase product: http://localhost:8080/api/v1/products/{productId}/order/{quantity}
productId -> the id of the product you want to buy
quantity -> the quantity of that purchased product
Type: POST

4) Category api for getting counts of the products by their categories

count of products by categories: http://localhost:8080/api/v1/categories
Type: GET

For testing the embeded h2 db was not set and tests use real db. Tests are only written for product api and only for the controllers. The seperate layers are not tested.
