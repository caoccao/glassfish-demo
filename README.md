# GlassFish Demo

This is a simple GlassFish demo with HTTPS enabled.

## How to Run the Demo?

Run the demo in IDEA and visit https://localhost:8001/hello in a web browser. You should see "Hello World!" and timestamp.

## How to Manually Enable HTTPS?

### Create a Self-Signed Certificate

Run the following command to create a keystore. Password: gfdemo.

```sh
keytool -genkey -alias demo -keyalg RSA -keystore ./keystore/demo.jks -keysize 2048 -validity 365
```

The input and output is as follows.

```txt
What is your first and last name?
  [Unknown]:  Demo
What is the name of your organizational unit?
  [Unknown]:  Demo
What is the name of your organization?
  [Unknown]:  Demo
What is the name of your City or Locality?
  [Unknown]:  Demo
What is the name of your State or Province?
  [Unknown]:  Demo
What is the two-letter country code for this unit?
  [Unknown]:  GF
Is CN=Demo, OU=Demo, O=Demo, L=Demo, ST=Demo, C=GF correct?
  [no]:  yes

Generating 2,048 bit RSA key pair and self-signed certificate (SHA256withRSA) with a validity of 365 days
        for: CN=Demo, OU=Demo, O=Demo, L=Demo, ST=Demo, C=GF
```

### List Certificates

```sh
keytool -list -v -keystore ./keystore/demo.jks
```
