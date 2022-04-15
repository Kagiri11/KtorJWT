# JWT Auth in Ktor :key:
A pet project showing how to provide JWT using a Ktor service.

## Content
- Server Configuration
- Utils
- JWT

### **Server Configuration**
We first fire off our server with a [Netty engine](https://netty.io/) configuration. 
It is in this server's application pipeline that we shall add our functionalities/ [plugins](https://ktor.io/docs/plugins.html#dependency).

### Utils
In here we have the [Kmongo](https://litote.org/kmongo/) database which we use to store our users. Also hosted in here is our token manager class that reads properties from a config file from our projects resources.

### JWT
Using the token manager above, we verify tokens inside the authentication config block in our server's application line.


