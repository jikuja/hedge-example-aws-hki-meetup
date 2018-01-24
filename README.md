# TODO: if this message is visible author has failed his job and forgot to fix hedge dependency version and remove this TODO

# Hedge demo for AWS Helsinki meetup

# Requirements

## Required software

1. Java 8 JDK - Boot runs on JVM
2. [Boot-CLJ](https://github.com/boot-clj/boot) - Required to build ClojureScript projects and run Hedge
3. AWS [CLI](https://aws.amazon.com/cli/). Optional. Might be useful for profile creation

## Authentication

Hedge use AWS SDK authentication methods:

1. `~/.aws/credentials` file or
2. environment variables

Refer [SDK documentation](https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/index.html?com/amazonaws/auth/profile/ProfileCredentialsProvider.html)
for full list of credential storages and detailed documentation.

Consult [AWS CLI  documentation](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html#cli-quick-configuration)
for more information if you don't have working AWS credentials.

Note: Hedge does not have any command line arguments to control authentication.
`AWS_PROFILE` environment variable can be used to select other
credential profile than "default".

# Deployment

First clone this repository if you already have not done it.
Following commands are executed in the cloned directory

To compile and deploy your project to AWS:

    boot deploy-aws -n <STACK_NAME>

Command checks that `STACK_NAME` name is free. If it is free project
is deployed into Cloudformation stack with given name. If name
is reserved error message is shown. After build and deployment steps command print API endpoint base URL.

Technical note: command check if S3 bucket with name
`hedge-<STACK_NAME>` is free. This might be changed
in the future.

This project has two configured endpoint:
1. http://<API_ENDPOINT_URL>/aws-meetup-hello -- Simple hello-world endpoint
2. http://<API_ENDPOINT_URL>/aws-meetup-calc -- Advanced enpoint using query parameters. Try e.g.
   http://<API_ENDPOINT_URL>/aws-meetup-calc?op=*&value1=11&value2=2

# Artifact creation and deployment

Run e.g. command `boot deploy-to-directory -d my-artifacts` to build and create artifacts. Then later
built artifacts can be deployed with command `boot deploy-from-directory -d my-artifacts -n <STACK_NAME>`

# Getting help
Running command boot will list all available command. Hedge specific commands are listed in the block
before environment variable list.

To get information about specific command you can run command `boot <COMMAND> -h` to see list of
supported command line arguments and their descriptions.

# Hedge example project for AWS

Refer [Hedge documentation](https://github.com/siilisolutions/hedge/) for detailed information.

## License

Copyright © 2016-2017 [Siili Solutions Plc.](http://www.siili.com)

Distributed under the [Eclipse Public License 1.0.](https://www.eclipse.org/legal/epl-v10.html)
