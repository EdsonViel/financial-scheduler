# Build do frontend
FROM node:22 AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build -- --configuration production

# Servir via Nginx
FROM nginx:stable-alpine
COPY --from=build /app/dist/frontend/browser/ /usr/share/nginx/html/
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
